<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * Session Model
 *
 * @property \App\Model\Table\CountObservationsTable|\Cake\ORM\Association\BelongsToMany $CountObservations
 * @property \App\Model\Table\CountObservationsTable|\Cake\ORM\Association\BelongsToMany $CountObservations
 *
 * @method \App\Model\Entity\Session get($primaryKey, $options = [])
 * @method \App\Model\Entity\Session newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\Session[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\Session|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\Session patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\Session[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\Session findOrCreate($search, callable $callback = null, $options = [])
 */
class SessionTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('session');
        $this->setDisplayField('ID');
        $this->setPrimaryKey('ID');

        $this->belongsToMany('CountObservations', [
            'foreignKey' => 'session_id',
            'targetForeignKey' => 'count_observation_id',
            'joinTable' => 'count_observations_session'
        ]);
        $this->belongsToMany('CountObservations', [
            'foreignKey' => 'session_id',
            'targetForeignKey' => 'count_observation_id',
            'joinTable' => 'count_observations_sessions_user'
        ]);
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->integer('ID')
            ->allowEmpty('ID', 'create');

        $validator
            ->boolean('Validated')
            ->requirePresence('Validated', 'create')
            ->notEmpty('Validated');

        $validator
            ->dateTime('Date')
            ->requirePresence('Date', 'create')
            ->notEmpty('Date');

        $validator
            ->numeric('Latitude')
            ->requirePresence('Latitude', 'create')
            ->notEmpty('Latitude');

        $validator
            ->numeric('Longitude')
            ->requirePresence('Longitude', 'create')
            ->notEmpty('Longitude');

        $validator
            ->scalar('Comment')
            ->maxLength('Comment', 512)
            ->requirePresence('Comment', 'create')
            ->notEmpty('Comment');

        $validator
            ->integer('User_ID')
            ->requirePresence('User_ID', 'create')
            ->notEmpty('User_ID');

        return $validator;
    }
}
