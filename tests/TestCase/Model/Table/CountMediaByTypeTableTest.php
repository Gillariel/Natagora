<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountMediaByTypeTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountMediaByTypeTable Test Case
 */
class CountMediaByTypeTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountMediaByTypeTable
     */
    public $CountMediaByType;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_media_by_type'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountMediaByType') ? [] : ['className' => CountMediaByTypeTable::class];
        $this->CountMediaByType = TableRegistry::get('CountMediaByType', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountMediaByType);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
