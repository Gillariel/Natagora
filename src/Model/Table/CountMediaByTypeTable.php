<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountMediaByType Model
 *
 * @method \App\Model\Entity\CountMediaByType get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountMediaByType newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountMediaByType[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountMediaByType|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountMediaByType patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountMediaByType[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountMediaByType findOrCreate($search, callable $callback = null, $options = [])
 */
class CountMediaByTypeTable extends Table
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

        $this->setTable('count_media_by_type');
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
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        $validator
            ->scalar('Type')
            ->maxLength('Type', 20)
            ->requirePresence('Type', 'create')
            ->notEmpty('Type');

        return $validator;
    }
}
