<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountReportedComments Model
 *
 * @method \App\Model\Entity\CountReportedComment get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountReportedComment newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountReportedComment[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountReportedComment|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountReportedComment patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountReportedComment[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountReportedComment findOrCreate($search, callable $callback = null, $options = [])
 */
class CountReportedCommentsTable extends Table
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

        $this->setTable('count_reported_comments');
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

        return $validator;
    }
}
